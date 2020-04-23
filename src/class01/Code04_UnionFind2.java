package class01;

import java.util.*;

public class Code04_UnionFind2 {

	//并查集
	public static class Element<V> {
		public V value;

		public Element(V value) {
			this.value = value;
		}

	}

	public static class UnionFindSet<V> {
		public HashMap<V, Element<V>> elementMap;
		public HashMap<Element<V>, Element<V>> fatherMap;
		public HashMap<Element<V>, Integer> rankMap;

		public UnionFindSet(List<V> list) {
			list.stream().forEach(obj->{
				Element<V> element = new Element<>(obj);
				elementMap.put(obj,element);
				fatherMap.put(element,element);
				rankMap.put(element,1);
			});
		}

		private Element<V> findHead(Element<V> element) {
			Stack<Element<V>> path = new Stack<>();
			while (element != fatherMap.get(element)) {
				path.push(element);
				element = fatherMap.get(element);
			}
			while (!path.isEmpty()) {
				fatherMap.put(path.pop(), element);
			}
			return element;
		}

		public boolean isSameSet(V a, V b) {
			if(elementMap.containsKey(a) && elementMap.containsKey(b)){
				return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
			}
			return false;
		}

		public void union(V a, V b) {
			Element<V> afElement = findHead(elementMap.get(a));
			Element<V> bfElement = findHead(elementMap.get(b));
			if(afElement != bfElement){
				Element<V> bigElement = rankMap.get(afElement)>rankMap.get(bfElement)?afElement:bfElement;
				Element<V> smallElement = rankMap.get(afElement)<rankMap.get(bfElement)?afElement:bfElement;
				rankMap.put(bigElement,rankMap.get(bigElement)+rankMap.get(smallElement));
				rankMap.remove(smallElement);
				fatherMap.put(smallElement,bigElement);
			}

		}

	}

}
