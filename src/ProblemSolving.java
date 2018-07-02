import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProblemSolving {
	
	public static void main (String[] args) {
		int i = alternatingCharacters("ABAB");
		System.out.println(i);
	}
	

	
	 static int[] climbingLeaderboard(int[] scores, int[] alice) {
	        int count = 1;
	        int prev = scores[0];
	        Map<Integer,Integer> tm = new TreeMap<>();
	        for(int i = 1; i < scores.length; i++){
	            if(scores[i] != prev) {
	            	tm.put(count, prev);
	            	count++;
	            }
	            prev = scores[i];
	        }
	        
	        if(!tm.containsKey(scores[scores.length - 1])) {
	        	tm.put(count, scores[scores.length - 1]);
	        }
	        
	        int [] place = new int[alice.length];
	        for(int i = 0; i < place.length; i++) {
	        	place[i] = get_place(tm, alice[i]);
	        }
	        return place;
	    }
	 
	 static int get_place(Map<Integer,Integer> tm, int alice) {
		 int place = -1, score = -1;
		 
		   for(Map.Entry<Integer,Integer> entry : tm.entrySet()) {
	        	 place = entry.getKey();
	        	 score = entry.getValue();
	        	 if(alice >= score)return place;
	        }
		   if(place == -1)return 1;
		   return place + 1;
	 }
	 
	// Complete the minimumDistances function below.
	    static int minimumDistances(int[] a) {
	    	
	    	int min_dist = a.length + 1;
	    	
	    	for(int i = 0; i < a.length; i++) {
	    		for(int j = i + 1; j < a.length; j++) {
	    			int dist = min_dist;
	    			if(a[i] == a[j])dist = (j-i);
	    			if(dist < min_dist)min_dist = dist;
	    		}
	    	}
	    	
	    	
	    	if(min_dist == a.length + 1)return -1;
	    	
	    	return min_dist;

//	    	HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
//	    	
//	    	for(int i = 0; i < a.length; i++) {
//	    		int num = a[i];
//	    		if(hm.containsKey(num)) {
//	    			ArrayList<Integer> index = hm.get(num);
//	    			index.
//	    		}
//	    	}
	    	
	    }
	    
	 // Complete the super_reduced_string function below.
	    static int twoCharaters(String s) {
	    	
	    	if(s.length() ==  2 && s.charAt(0) != s.charAt(1)) {
	    		return 2;
	    	}
	    	
	    	int max = 0;
	    	
	    	for(char a = 'a'; a <= 'z'; a++) {
	    		for(char b = 'a'; b <= 'z'; b++) {
		    		char c1 = a, c2 = b;
		    		String newStr = "";
		    		for(int i = 0; i < s.length(); i++) {
		    			if(s.charAt(i) == c1 || s.charAt(i) == c2)newStr += s.charAt(i);
		    		}
		    		if(newStr.matches("^([a-z])(?!\\1)([a-z])(?:\\1\\2)*\\1?$")) {
		    			System.out.println(newStr);
		    			if(newStr.length() > max)max = newStr.length();
		    		}
		    		
		    	}
	    	}
	    	
	    	return max;

	    }
	    
	 // Complete the divisibleSumPairs function below.
	    static int divisibleSumPairs(int n, int k, int[] ar) {
	    	int count = 0;
	    	int [] mod = new int [k];
	    	for(int i = 0; i < k; i++)mod[i] = 0;
	    	for(int i = 0; i < ar.length; i++){
	    		count += mod[ar[i] % k];
                 mod[ar[i] % k] += 1;
            }
	    	return count;
	    }
	    
	 // Complete the permutationEquation function below.
	    static ArrayList<Integer> permutationEquation(int[] p) {
	    	
	    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    	for(int i = 0; i < p.length; i++) {
	    		map.put(p[i], i + 1);
	    	}
	    	
	    	ArrayList<Integer> values = new ArrayList<Integer>();
	    	
	    	for(int i = 0; i < p.length; i++) {
	    		int x = i + 1;
	    		Integer n = map.get(x);
	    		if(n == null)continue;
	    		Integer m = map.get(n);
	    		if(m == null)continue;
	    		values.add(m);
	    	}
	    	return values;
	    }
	    
	    static String decToBinary(int n)
	    {
	        // array to store binary number
	        int[] binaryNum = new int[1000];
	  
	        // counter for binary array
	        int i = 0;
	        while (n > 0) 
	        {
	            // storing remainder in binary array
	            binaryNum[i] = n % 2;
	            n = n / 2;
	            i++;
	        }
	        
	        String s = "";
	  
	        // printing binary array in reverse order
	        for (int j = i - 1; j >= 0; j--)
	            s += binaryNum[j];
	        return s;
	    }
	    
	 // Complete the acmTeam function below.
	    static int[] acmTeam(String[] topic) {
	    	
	    	TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

	    	for(int i = 0; i < topic.length; i++) {
	    		BigInteger one = new BigInteger(topic[i], 2);
	    		for(int j = i + 1; j < topic.length; j++) {
	    			BigInteger two = new BigInteger(topic[j], 2);
	    			BigInteger or = one.or(two);
	    			int num_bits = or.bitCount();
	    			if(map.containsKey(num_bits)) {
	    				map.put(num_bits, map.get(num_bits) + 1);
	    			}else {
	    				map.put(num_bits, 1);
	    			}
	    		}
	    	}
	    	int [] ans = {map.lastKey(), map.get(map.lastKey())};
	    	return ans;
	    }
	    
	 // Complete the icecreamParlor function below.
	    static int[] icecreamParlor(int m, int[] arr) {
	    	for(int i = 0; i < arr.length; i++) {
	    		for(int j = i + 1; j < arr.length; j++) {
	    			int sum = arr[i] + arr[j];
	    			if(sum == m) {
	    				return new int[] {i + 1,j + 1};
	    			}
	    		}
	    	}
	    	return new int [] {};
	    }
	    
	 // Complete the larrysArray function below.
	    static String larrysArray(int[] a) {
	    	
	    	int count = 0;

	    	for(int i = 1; i < a.length; i++) {
	    		for(int j = i; j >= 1; j--) {
	    			if(a[j] < a[j - 1]) {
	    				int temp =  a[j];
	    				a[j] = a[j - 1];
	    				a[j - 1] = temp;
	    				count++;
	    			}else
	    				break;
	    		}
	    	}
	    	if(count % 2 == 0)return "YES";
	    	return "NO";
	    }
	    
	 // Complete the cutTheSticks function below.
	    static int[] cutTheSticks(int[] arr) {
	    	Arrays.sort(arr);
	    	ArrayList<Integer> a = new ArrayList<Integer>();
	    	ArrayList<Integer> num_sticks = new ArrayList<Integer>();
	    	for(int i : arr)a.add(i);
	    	int smallest = a.get(0);
	    	
	    	while(a.size() > 1 && !exit(a)) {
	    		num_sticks.add(a.size());
	    		for(int i = 0; i < a.size(); i++) {
		    		a.set(i, a.get(i) - smallest);
		    		if(a.get(i) == 0){
	    		        a.remove(i--);
	    		    }
		    	}
		    	smallest = a.get(0);
	    	}
	    		    	
	    	if(a.size() == 1)num_sticks.add(1);
	    	else if(exit(a))num_sticks.add(a.get(0));

	    	
	    	
	    	int [] n = new int[num_sticks.size()];
	    	for(int i = 0; i < n.length; i++)n[i] = num_sticks.get(i);
	    	return n;
	    	
	    }
	    
	    static long aVeryBigSum(long[] ar) {
	        long sum = 0;
	        for(int i = 0; i < ar.length; i++)sum += ar[i];
	        return sum;
	    }
	    	    
	    static boolean exit(ArrayList<Integer> arr) {
	    	int prev = arr.get(0);
	    	for(int i = 1; i < arr.size(); i++) {
	    		if(arr.get(i) != prev)return false;
	    	}
	    	return true;
	    }
	    
	 // Complete the libraryFine function below.
	    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
	    	if(y1 < y2 || (y1 == y2 && m1 < m2) || (y1 == y2 && m1 == m2 && d1 < d2))return 0;
	    	if(y1 == y2 && m1 == m2)return (d1 - d2) * 15;
	    	if(y1 == y2)return (m1 - m2) * 500;
	    	return 10000;

	    }
	    
	 // Complete the findDigits function below.
	    static int findDigits(int n) {
	    	
	    	int temp = n, count = 0;
	    	
	    	while(n != 0) {
	    		int dig = n % 10;
	    		if(dig != 0 && temp % dig == 0)count++;
	    		n /= 10;
	    	}
	    	
	    	return count;

	    }
	    
	 // Complete the pickingNumbers function below.
	    static int pickingNumbers(int[] a) {
	    	Arrays.sort(a);
	    	
	    	for(int i : a)System.out.print(i + " ");
	    	System.out.println("");
	    	
	    	int max = 0;
	    	
	    	for(int i = 0; i < a.length; i++) {
	    		boolean start = false;
	    		int count = 0;
	    		for(int j = 0; j < a.length; j++) {
	    			if(i == j)continue;
	    			int diff = Math.abs(a[i] - a[j]);
	    			System.out.println(a[i] + " " + a[j]);
	    			if(diff == 1 && !start) {
	    				start = true;
	    				count++;
	    			}
	    			if(diff == 1 && start)count++;
	    			if(diff != 1 && start) {
	    				if(count > max)max = count;
	    				break;
	    			}
	    		}
				System.out.println("----------- " + count +  " count");
	    	}
	    	
	    	return max + 1;

	    }
	    
	    public static int countBits(int number) { 
			int count = 0; for(int i =0; i<32; i++){ if( (number&1) == 1) { count++; } number = number >>> 1; } return count;
		}
	    
	 // Complete the kaprekarNumbers function below.
	    static void kaprekarNumbers(int p, int q) {
	    	int count = 0;
	        for(int i = p; i <= q; i++){
	            if(isKap(i)) {
	            	count++;
	            	System.out.print(i + " ");
	            }
	        }
	        if(count == 0) {
	        	System.out.println("INVALID RANGE");
	        }
	    }
	    
	    static boolean isKap(int i){
	        String sq = String.valueOf((int)Math.pow(i, 2));
	        int dig1 = 0;
	        try {
	        	dig1 = Integer.valueOf(sq.substring(0, sq.length()/2));
	        }catch(Exception e) {
	        	dig1 = 0;
	        }
	        int dig2 = 0;
	        try {
	        	dig2 = Integer.valueOf(sq.substring(sq.length()/2));
	        }catch(Exception e) {
	        	dig2 = 0;
	        }
	        return ((dig1 + dig2) == i);
	    }
	    
	 // Complete the kangaroo function below.
	    static String kangaroo(int x1, int v1, int x2, int v2) {
	    	double t = (double) ((double)(x2 - x1)/(double)(v1-v2));
	    		    	
	    	if(t >= 0.0 && (t == Math.floor(t)) && !Double.isInfinite(t))return "YES";
	    	
	    	return "NO";

	    }
	    
	 // Complete the alternatingCharacters function below.
	    static int alternatingCharacters(String s) {
	    	if(s.length() <= 1)return 0;
	    	int count = 0;
	    	
	    	for(int i = 0; i < s.length() - 1; i++) {
	    		if(s.charAt(i+1) == s.charAt(i))count++;
	    	}
	    		    	
	    	return count;

	    }
	    
	 // Complete the jumpingOnClouds function below.
	    static int jumpingOnClouds(int[] c, int k) {
	    	int e = 100;
	        int n = c.length;
	        int i = k % n;
	        	        
	        	        
	        while(i != 0) {
	        	 e = (c[i] == 1) ? (e-=3) : (e-=1);
	        	 //if(e < 0) e = 0;
	        	 i = ((i + k) % n);
	        }
	        
	        e = (c[i] == 1) ? (e-=3) : (e-=1);
	        
	        
	        return e;
	        
//	        while(&& e > 0){
//	            System.out.println("Ever After");
//	            e--;
//	        }
	    }
	    
	    // Complete the minimumNumber function below.
	    static int minimumNumber(int n, String password) {
	        boolean [] c = new boolean[5];
	        for(int i = 0; i < c.length; i++)c[i] = false;
	        char [] sc = {'!','@','#','$','%','^','&','*','(',')','-','+'};
	        
	        if(n >= 6)c[0]= true;
	        
	        for(int i = 0; i < n; i++) {
	        	char cc = password.charAt(i);
	        	if(cc >= '0' && cc <= '9' && !c[1])c[1] = true;
	        	else if(cc >= 'a' && cc <= 'z' && !c[2])c[2] = true;
	        	else if(cc >= 'A' && cc <= 'Z' && !c[3])c[3] = true;
	        	if(!c[4]) {
	        		for(int j = 0; j < sc.length; j++) {
		        		if(sc[j] == cc) {
		        			c[4] = true;
		        			break;
		        		}
		        	}
	        	}
	        }
	        	        
	        int str_len = password.length();
	        	        
	        if(!c[4]) {
	        	str_len++;
	        	if(!c[0] && str_len >= 6)c[0] = true;
	        }
	        
	        if(!c[3]) {
	        	str_len++;
	        	if(!c[0] && str_len >= 6)c[0] = true;
	        }
	        
	        if(!c[2]) {
	        	str_len++;
	        	if(!c[0] && str_len >= 6)c[0] = true;
	        }
	        
	        if(!c[1]) {
	        	str_len++;
	        	if(!c[0] && str_len >= 6)c[0] = true;
	        }
	        
	        if(!c[0]) {
	        	int len = 6 - str_len;
	        	str_len += len;
	        }
	        
	        return str_len - password.length();
	        

	    }
	    
	    
	    
	 // Complete the beautifulDays function below.
	    static int beautifulDays(int i, int j, int k) {
	    	
	    	int count = 0;
	    	
	    	for(int m = i; m <= j; m++) {
	    		String s = String.valueOf(m);
	    		s = new StringBuilder(s).reverse().toString();
	    		int rev = Integer.valueOf(s);
	    		if(Math.abs(m - rev) % k == 0)count++;
	    	}
	    	
	    	return count;

	    }
	    
	    static void miniMaxSum(int[] arr) {
	    	Arrays.sort(arr);
	    	BigInteger min = val(arr[0]).add(val(arr[1]).add(val(arr[2]).add(val(arr[3]))));
	    	BigInteger max = val(arr[4]).add(val(arr[3]).add(val(arr[2]).add(val(arr[1]))));
	    	System.out.println(min.toString() + " " + max.toString());
	    }
	    
	    static BigInteger val(int i) {
	    	return BigInteger.valueOf(i);
	    }
	    
	    static void extraLongFactorials(int n) {
	        BigInteger bi = BigInteger.valueOf(n);
	        BigInteger result = fact(bi);
	        System.out.println(result.toString());
	    }
	    
	    static BigInteger fact(BigInteger n) {
	    	if(n.equals(BigInteger.valueOf(1)))return BigInteger.valueOf(1);
	    	return n.multiply(fact(n.subtract(BigInteger.valueOf(1))));
	    }
	    
	    static String encryption(String s) {
	    	s = s.replaceAll("\\s+","");
	    	int len = s.length();
	    	int lower = (int) Math.floor(Math.sqrt(len));
	    	int upper = (int) Math.ceil(Math.sqrt(len));
	    	int row, col;
	    	if(upper - lower == 1 || upper == lower) {
	    		row = lower;
	    		col = upper;
	    	}else {
	    		row = lower;
	    		col = lower + 1;
	    	}
	    	
	    	//ArrayList<String> words = new ArrayList<Strings>();
	    	String new_s = "";
	    	int col_count = 0;
	    	String [] words = new String[col];
	    	
	    	for(int i = 0; i < col; i++)words[i] = "";
	    	
	    	
	    	for(int i = 0; i < s.length(); i++) {
	    		if(col_count >= col)col_count = 0;
	    		words[col_count] += s.charAt(i);
	    		col_count++;
	    	}
	    	
	    	
	    	for(int i = 0; i < words.length; i++) {
	    		new_s += words[i] + " ";
	    	}
	    	
	    	return new_s;
	    	
	    }
	    
	    static int saveThePrisoner(int n, int m, int s) {
            int rem = m % n;
            int ans = 0;
            if((s + rem) > n)ans = ((s + rem) - n) - 1;
            else ans = (s + rem) - 1;
            if(ans == 0)return n;
            return ans;

    }
	    
	    static int saveThePrisoner2(int n, int m, int s) {
            int rem = (s + m - 1) % n;
            // s -= 1;
            // if((s + rem) > n)return ((s + rem) - n);
            // return (s + rem);
            if(rem == 0)return n;
            return rem;

    }

}
