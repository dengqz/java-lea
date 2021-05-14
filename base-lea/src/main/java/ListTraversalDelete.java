import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List的遍历删除问题
 *
 * (1)循环删除list中特定一个元素的，可以使用三种方式中的任意一种，但在使用中要注意上面分析的各个问题。
 *
 * (2)循环删除list中多个元素的，应该使用迭代器iterator方式或者倒叙删除。
 *
 * https://blog.csdn.net/m0_37372711/article/details/54613741
 *
 * https://blog.csdn.net/zbajie001/article/details/84531595s
 */
public class ListTraversalDelete {
	/**
	 * 这种方式的问题在于，
	 * 删除元素后继续循环会报错误信息ConcurrentModificationException，
	 * 因为元素在使用的时候发生了并发的修改，导致异常抛出。
	 * 但是删除完毕马上使用break跳出，则不会触发报错。
	 */
	public static List<String> remove1(List<String> list) {
		for (String item : list) {
			if ("d".equals(item))
				list.remove(item);
			//break;
		}
		System.out.println(list);
		return list;
	}

	/**
	 * 这种方式的问题在于，删除某个元素后，list的大小发生了变化，而你的索引也在变化,
	 * 所以会导致你在遍历的时候漏掉某些元素。比如当你删除第1个元素后，继续根据索引访问第2个元素时，
	 * 因为删除的关系后面的元素都往前移动了一位，所以实际访问的是第3个元素。
	 * 因此，这种方式可以用在删除特定的一个元素时使用，但不适合循环删除多个元素时使用。
	 *
	 */
	public static List<String> remove2(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			int length = list.size();
			System.out.println("list表长度:" + length);
			if ("d".equals(list.get(i)))
				list.remove(i);
		}
		System.out.println(list);
		return list;
	}

	/**
	 * 这种方式可以正常的循环及删除。
	 * 但要注意的是，使用iterator的remove方法，
	 * 如果用list的remove方法同样会报上面提到的ConcurrentModificationException错误。
	 */
	public static List<String> remove3(List<String> list) {
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String s = iterator.next();
			if ("d".equals(s))
				list.remove(s);
				//iterator.remove();
		}
		System.out.println(list);
		return list;
	}

	/**
	 * 倒序删除
	 */
	public static List<String> remove4(List<String> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			if ("d".equals(list.get(i))) {
				list.remove(i);
			}
		}
		System.out.println(list);
		return list;
	}

	/**
	 * 使用jdk1.8新增的流功能，操作很简单便捷，效率也可以，比较推荐此方式。
	 */
	public static List<String> remove5(List<String> list) {
		list = list.stream().filter(e -> !"d".equals(e)).collect(Collectors.toList());
		System.out.println(list);
		return list;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("d");
		list.add("d");
		list.add("f");
		//remove1(list);
		//remove2(list);
		remove3(list);
		//remove4(list);
		//remove5(list);
	}
}
