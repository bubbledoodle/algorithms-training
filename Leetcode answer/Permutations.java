// for ArrayList usage
import java.util.*; 

// file name has to be the same as class name
public class Permutations {

	public static void main(String[] args){
		if (args.length < 1) {
			System.out.println("Usage: java Permutations [word]");
			return;
		}

		String word = args[0];

		ArrayList<String> list = new ArrayList<String>();

		Permutations.perm1(list, word);

		System.out.println(list);

		return;
	}

	public static void perm1(List<String> list, String s) { perm1(list, "", s);}

	private static void perm1(List<String> answer, String prefix, String s) {
		
		int n = s.length();
		if(n == 0) {
			answer.add(prefix);
			return;
		}
		else {
			for(int i=0; i<n; i++) {
				perm1(answer, prefix + s.charAt(i), s.substring(0,i) + s.substring(i+1, n));
			}
		}
	}
}