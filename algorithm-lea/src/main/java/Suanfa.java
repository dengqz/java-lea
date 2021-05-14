import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Suanfa {
	static Class<?> comparableClassFor(Object x) {
		if (x instanceof Comparable) {  // 判断是否实现了Comparable接口
			Class<?> c; Type[] ts, as; Type t; ParameterizedType p;
			if ((c = x.getClass()) == String.class)
				return c;   // 如果是String类型，直接返回String.class
			if ((ts = c.getGenericInterfaces()) != null) {  // 判断是否有直接实现的接口
				for (int i = 0; i < ts.length; ++i) {   // 遍历直接实现的接口
					if (((t = ts[i]) instanceof ParameterizedType) &&   // 该接口实现了泛型
							((p = (ParameterizedType) t).getRawType() == // 获取接口不带参数部分的类型对象
									Comparable.class) &&   //  该类型是Comparable
							(as = p.getActualTypeArguments()) != null &&    // 获取泛型参数数组
							as.length == 1 && as[0] == c)   // 只有一个泛型参数，且该实现类型是该类型本身
						return c;   // 返回该类型
				}
			}
		}
		return null;
	}

	/**
	 * Returns k.compareTo(x) if x matches kc (k's screened comparable
	 * class), else 0.
	 * 如果x的类型是kc，返回k.compareTo(x)的比较结果
	 * 如果x为空，或者类型不是kc，返回0
	 */
	@SuppressWarnings({"rawtypes", "unchecked"}) // for cast to Comparable
	static int compareComparables(Class<?> kc, Object k, Object x) {
		return (x == null || x.getClass() != kc ? 0 :
				((Comparable) k).compareTo(x));
	}

	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
	}

	public static int numberof1(long n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

	public static int number(int n) {

		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; ++i) {
			if (hashtable.containsKey(target - nums[i])) {
				return new int[] {hashtable.get(target - nums[i]), i};
			}
			hashtable.put(nums[i], i);
		}
		return new int[0];
	}

	public static void main(String[] args) {
		/*tableSizeFor(12);
		HashMap<Integer,String> hashmap= new HashMap<>(8);
		hashmap.put(1,"ds");
		HashMap<Integer,String> hashmap1= new HashMap<>(hashmap);
		hashmap1.entrySet().forEach(stringStringEntry -> System.out.println(stringStringEntry.getKey() + "=" + stringStringEntry.getValue())
		);
		System.out.println(Long.toBinaryString(-9));
		System.out.println(numberof1(-9));*/

		/*int[] arrs = new int[]{1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.toString(twoSum(arrs,15)));*/


	}
}

