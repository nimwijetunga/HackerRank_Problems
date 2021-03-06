import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProblemSolving {
	
	public static void main (String[] args) {
		String s = isValid("aabbcd");
		System.out.println(s);
	}
	
	// Complete the isValid function below.
    static String isValid(String s) {
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	for(char c : s.toCharArray()) {
    		if(map.containsKey(c)) {
    			map.put(c, map.get(c) + 1);
    		}else {
    			map.put(c, 1);
    		}
    	}
    	
    	
    	HashMap<Integer, Integer> occur_map = new HashMap<Integer, Integer>();
    	for(int i : map.values()) {
    		if(occur_map.containsKey(i)) {
    			occur_map.put(i, occur_map.get(i) + 1);
    		}else {
    			occur_map.put(i, 1);
    		}
    	}
    	
    	int size = occur_map.size();
    	if(size == 1) return "YES";
    	else if (size > 2) return "NO";
    	
    	ArrayList<Integer> keys = new ArrayList<Integer>();
    	ArrayList<Integer> values = new ArrayList<Integer>();

    	for(int i : occur_map.keySet()) {
    		keys.add(i);
    		values.add(occur_map.get(i));
    	}
    	
    	if((keys.get(0) == 1 && values.get(0) == 1) || (keys.get(1) == 1 && values.get(1) == 1)) return "YES";
    	if(Math.abs(keys.get(0) - keys.get(1)) != 1) return "NO";
    	if(values.get(0) != 1 && values.get(1) !=  1) return "NO";

    	return "YES";
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
	    
	 // Complete the maxMin function below.
	    static int maxMin(int k, int[] arr) {
	    	Arrays.sort(arr);
	    	double score = Double.POSITIVE_INFINITY;
	    	for(int i = 0; i < arr.length; i++) {
	    		boolean check = true;
	    		ArrayList<Integer> tmp = new ArrayList<Integer>();
	    		int lower = i, upper = (k + i) -1;
	    		if(upper >= arr.length)break;
	    		double max = arr[upper], min = arr[lower];
		    	if(check && (max - min) < score)score = (max-min);
	    	}
	    	if(score == Double.POSITIVE_INFINITY) return -1;
	    	return ((int) score);
	    }
	    
	 // Complete the toys function below.
	    static int toys(int[] w) {
	    	Arrays.sort(w);
	    	int max_w = w[0] + 4, cont = 0;
	    	for(int i = 0; i < w.length; i++) {
	    		if(w[i] > max_w) {
	    			cont++;
	    			max_w = w[i] + 4;
	    		}
	    	}
	    	cont++;
	    	return cont;
	    }
	    
	 // Complete the jimOrders function below.
	    static int[] jimOrders(int[][] orders) {
	    	BST order_tree = new BST();
	    	for(int i = 0; i < orders.length; i++) {
	    		int total_serve_time = orders[i][0] + orders[i][1];
	    		int cust = (i + 1);
	    		order_tree.put(total_serve_time, cust);
	    	}
	    	
	    	ArrayList<Integer> serve_order = order_tree.get_serve_order();
	    	
	    	int [] order = new int [serve_order.size()];
	    	for(int i = 0; i < serve_order.size(); i++) {
	    		order[i] = serve_order.get(i);
	    	}
	    	
	    	return order;

	    }
	    
	 // Complete the insertionSort1 function below.
	    static void insertionSort1(int n, int[] arr) {

	    	int num = arr[n - 1];
	    	for(int i = arr.length - 2; i >= 0; i--) {
	    		if(arr[i] > num) {
	    			arr[i + 1] = arr[i];
	    		}else {
	    			arr[i + 1] = num;
	    			printArr(arr);
	    			break;
	    		}
	    		printArr(arr);
	    	}
	    	if(arr[0] > num) {
	    		int temp = arr[0];
	    		arr[0] = num;
	    		arr[1] = temp;
	    		printArr(arr);
	    	}

	    }
	    
	    /*
	     * Complete the twosCompliment function below.
	     */
	    static long twosCompliment(long a, long b) {
	    	long count = 0;
	    	for(long l = a; l <=b ; l++) {
	    		long cur = Math.abs(l);
    			String cur_str = Long.toBinaryString( cur | 0x100000000L ).substring(1);
	    		if(l < 0) {
	    			count += num_ones_twos_comp(cur_str);
	    		}else {
	    			count += num_ones(cur_str);
	    		}
	    	}
	    	return count;

	    }
	    
	    static int num_ones_twos_comp(String s) {
	    	int count = 0;
	    	boolean first_one = false;
	    	for(int i = s.length() - 1; i >= 0; i--) {
	    		if(!first_one && s.charAt(i) == '1') {
	    			count++;
	    			first_one = true;
	    		}else if(first_one && s.charAt(i) == '0') {
	    			count++;
	    		}
	    	}
	    	return count;
	    }
	    
	    static int num_ones(String s) {
	    	int count = 0;

	    	for(int i = s.length() - 1; i >= 0; i--) {
	    		if(s.charAt(i) == '1')count++;
	    	}
	    	return count;
	    }
	    
	    static void printArr(int [] arr) {
	    	for(int i : arr) {
	    		System.out.print(i + " ");
	    	}
	    	System.out.println("");
	    }
	    
	    static int[] left_rot(int [] a, int d) {
	    	HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
	    	
	    	for(int i = 0; i < a.length; i++) {
	    		int new_index = i - d;
	    		if(new_index < 0) {
	    			new_index = a.length + new_index;
	    		}
	    		mp.put(new_index, a[i]);
	    	}
	    	
	    	int [] new_arr = new int[a.length];
	    	
	    	for(int i : mp.keySet()) {
	    		new_arr[i] = mp.get(i);
	    	}
	    	
	    	for(int i : new_arr) System.out.print(i + " ");
	    	
	    	return new_arr;
	    }
	    
	 // Complete the isBalanced function below.
	    static String isBalanced(String s) {
	    	for(int i = 0; i < s.length(); i++) {
	    		if((s.length() - 1 - i) < i) break;
	    		char c1 = s.charAt(i);
	    		char c2 = s.charAt(s.length() - 1 - i);
	    		if(c1 == '(') {
	    			if (c2 != ')') return "NO";
	    		}else if(c1 == '[') {
	    			if (c2 != ']') return "NO";
	    		}else if(c1 == '{') {
	    			if (c2 != '}') return "NO";
	    		}else {
	    			return "NO";
	    		}
	    	}
	    	return "YES";
	    }
	    
	    
	 // Complete the lonelyinteger function below.
	    static int lonelyinteger(int[] a) {
	    	HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
	    	for(int i = 0; i < a.length; i++) {
	    		int cur = a[i];
	    		if(mp.containsKey(cur)) {
	    			mp.remove(cur);
	    		}else {
	    			mp.put(cur, 1);
	    		}
	    	}
	    	for(int i : mp.keySet()) {
	    		return i;
	    	}
	    	return 0;
	    }
	    
	    
	    static int introTutorial(int V, int [] arr) {
	    	int high = arr.length - 1, low = 0, mid = (low + high) / 2;
	    	while(high >= low) {
	    		if(arr[mid] == V) {
	    			return mid;
	    		}
	    		else if(arr[mid] < V) {
	    			low = mid + 1;
	    		}
	    		else if(arr[mid] > V) {
	    			high = mid - 1;
	    		}
	    		mid = (high + low) / 2;
	    	}
	    	return -1;
	    }
	    
	 // Complete the insertionSort2 function below.
	    static void insertionSort2(int n, int[] arr) {
	    	for(int i = 1; i < arr.length; i++) {
	    		for(int j = i; j >= 1 && arr[j] < arr[j - 1]; j--) {
	    			if(arr[j] < arr[j - 1]) {
	    				int temp = arr[j];
	    				arr[j] = arr[j - 1];
	    				arr[j - 1] = temp;
	    			}
	    		}
	    		printArr(arr);
	    	}

	    }
	    
	 // Complete the maximumToys function below.
	    static int maximumToys(int[] prices, int k) {
	    	Arrays.sort(prices);
	    	int cur_price = 0, count = 0;
	    	for(int i = 0; i < prices.length; i++) {
	    		if(cur_price + prices[i] > k)break;
	    		else count++;
	    		cur_price += prices[i];
	    	}
	    	return count;
	    }
	    
	 // Complete the getMinimumCost function below.
	    static int getMinimumCost(int k, int[] c) {
	    	Arrays.sort(c);
	    	int amount = 0, cost = 0;
	    	int count = 1;
	    	
	    	for(int i = c.length - 1; i >= 0; i--) {
	    		cost += (c[i] * (amount + 1));
	    		if(count % k == 0)amount++;
	    		count++;
	    	}
	    	
	    	return cost;
	    }
	    
	    /*
	     * Complete the waiter function below.
	     */
	    static void waiter(int[] number, int q) {
	        ArrayList<Integer> a_i = new ArrayList<Integer>();
	        for(int i : number)a_i.add(i);
	        HashMap<Integer, ArrayList<Integer>> b_i = new HashMap<Integer, ArrayList<Integer>>();
	    	int [] primes = firstNPrimes(q);
	    	int count = 0;
	    	for(int p : primes) {
	    		ArrayList<Integer> b_cur = new ArrayList<Integer>();
	    		ArrayList<Integer> a_cur = new ArrayList<Integer>();
	    		for(int i = a_i.size() - 1; i >= 0; i--) {
	    			int cur = a_i.get(i);
	    			if(cur% p == 0) b_cur.add(cur);
	    			else a_cur.add(cur);
	    		}
	    		b_i.put(++count, new ArrayList<>(b_cur));
	    		a_i = a_cur;
	    		b_cur.clear();
	    	}
	    	
	    	for(ArrayList<Integer> cur: b_i.values()) {
	    		for(int i = cur.size() - 1; i >= 0; i--) {
	    			System.out.println(cur.get(i));
	    		}
	    	}
	    	for(int i = a_i.size() - 1; i >= 0; i--) {
    			System.out.println(a_i.get(i));
    		}
	    	
	    }
	    
	    public static int[] firstNPrimes (int n){
	        int[] primes = new int[n];
	        int ncounter = 0;
	        int isPrime = 2;
	        while( ncounter < n){
	          boolean prime = true;
	          for (int j=2; j<isPrime; j++){
	            if (isPrime%j ==0){
	              prime = false;
	              break;
	            }
	          }
	          if (prime){
	            primes[ncounter] = isPrime;
	            ncounter++;
	          } 
	          isPrime++;
	         }
	        return primes;
	      }
	    
	    
	 // Complete the twoArrays function below.
	    static String twoArrays(int k, int[] A, int[] B) {
	    	Arrays.sort(A);
	    	Arrays.sort(B);
	    	int [] C = new int[B.length];
	    	int index = 0;
	    	for(int i = B.length - 1; i >= 0; i--) {
	    		C[index] = B[i];
	    		index++;
	    	}
	    	for(int i = 0; i < A.length; i++) {
	    		if(A[i] + C[i] < k)return "NO";
	    	}
	    	return "YES";
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
