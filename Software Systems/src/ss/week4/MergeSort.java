package ss.week4;

import java.util.*;

public class MergeSort {
    public static <Elem extends Comparable<Elem>>
           void mergesort(List<Elem> list) {
    			if (list.size() < 2) {
    				return;
    			}
    			
    			List<Elem> res = sort(list);
    			list.clear();
    			list.addAll(res);
    			System.out.println("\n\n");
    }
    
    public static <Elem extends Comparable<Elem>> List<Elem> 
    sort(List<Elem> list) {
    	System.out.println(list.toString());
    	if (list.size() < 2) {
    		return list;
    	}
    	
    	int index = list.size() / 2;
    	List<Elem> fst = sort(list.subList(0, index));
    	List<Elem> snd = sort(list.subList(index, list.size()));
    	
    	List<Elem> res = new ArrayList<>();
    	int fi = 0;
    	int si = 0;
    	while (fi < fst.size() && si < snd.size()) {
    		if (fst.get(fi).compareTo(snd.get(si)) < 0) {
    			res.add(fst.get(fi));
    			fi++;
    		} else {
    			res.add(snd.get(si));
    			si++;
    		}
    	}
    	
    	if (fi < fst.size() && si == snd.size()) {
    		res.addAll(fst.subList(fi, fst.size()));
    	} else if (si < snd.size() && fi == fst.size()) {
    		res.addAll(snd.subList(si, snd.size()));
    	}
    	
    	System.out.println(res.toString());
    	return res;
    }
}
