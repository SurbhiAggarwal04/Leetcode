package LeetCode;
/*
 * Given two binary strings, return their sum (also a binary string).

For example, a = "11", b = "1", the return is "100".
 */
public class AdditionOfBinaryNumbers {
	public String addBinary(String a, String b) {
		if (a.trim().equals(""))
			return b;
		if (b.trim().equals(""))
			return a;

		int lengthA = a.length();
		int lengthB = b.length();
		StringBuilder sbA = new StringBuilder(a);
		StringBuilder sbB = new StringBuilder(b);
		if (lengthA < lengthB) {
			for (int i = 0; i < lengthB - lengthA; i++) {
				sbA.insert(i, 0);
			}
		}
		if (lengthB < lengthA) {
			for (int i = 0; i < lengthA - lengthB; i++) {
				sbB.insert(i, 0);
			}
		}
		int carry = 0;
		StringBuilder result = new StringBuilder();

		int i = sbA.length() - 1;
		while (i >= 0) {
			if (sbA.charAt(i) == '1' && sbB.charAt(i) == '1') {
				if (carry == 0)
					result.insert(0, '0');
				else
					result.insert(0, '1');
				carry = 1;
			} else {
				if (sbA.charAt(i) == '0' && sbB.charAt(i) == '0') {
					result.insert(0, String.valueOf(carry));
					carry = 0;
				} else {
					if (carry == 0)
						result.insert(0, '1');
					else {
						result.insert(0, '0');
						carry = 1;
					}

				}

			}
			i--;
		}
		if (carry != 0)
			result.insert(0, String.valueOf(carry));
		return result.toString();

	}

	public String addBinaryv1(String a, String b) {
		if (a == null || a.length() == 0)
			return b;
		if (b == null || b.length() == 0)
			return a;

		int pa = a.length() - 1;
		int pb = b.length() - 1;

		int flag = 0;
		StringBuilder sb = new StringBuilder();
		while (pa >= 0 || pb >= 0) {
			int va = 0;
			int vb = 0;

			if (pa >= 0) {
				va = a.charAt(pa) == '0' ? 0 : 1;
				pa--;
			}
			if (pb >= 0) {
				vb = b.charAt(pb) == '0' ? 0 : 1;
				pb--;
			}

			int sum = va + vb + flag;
			if (sum >= 2) {
				sb.append(String.valueOf(sum - 2));
				flag = 1;
			} else {
				flag = 0;
				sb.append(String.valueOf(sum));
			}
		}

		if (flag == 1) {
			sb.append("1");
		}

		String reversed = sb.reverse().toString();
		return reversed;
	}
}
