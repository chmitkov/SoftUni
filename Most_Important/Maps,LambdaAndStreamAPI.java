Maps, Lambda and Stream API

Associative Arrays - collectino of Key - Value pairs

	- Keys are unique for all
	
	- HashMap

		- Uses a hash-table and List
	
	- LinkedHashMap 
	
		- Keeps the keys in order of addition
		
	- TreeMap
	
		- Keeps it keys allways sorted
	
		- Uses a balanced search tree
	
	- Build-In methods
	
		- map.put(key, value)
		- map.putIfAbsent(key, value)  <- Adding the key if does not exist
		- map.remove(key)
		- map.containsKey(key)
		- map.containsValue(value)
		- entry.getKey() and entry.getValue()
		

		
Lambda Expressions - Anonymous Functions

	Stream API - Traversing and Querying Collections 
	
		- int number = Arrays.stream(array).min()/.max()/.sum()/.average().getAsInt();
	
			- ArrayList<Integer> nums = new ArrayList<>(){{ add(15); add(40); add(60)}}; 
		
			int min = nums.stream().min(Integer::compareTo).get();
			int sum = nums.stream().max(Integer::intValue).sum();
			int average = nums.stream().mapToInt(Integer::intValue).average.getAsDouble();

		- .map() - manipulates elements in a collection
			
			Arrays.stream(array).map(w->w+"yyy").toArray(String[]::new);
			
			int[] nums = Arrays.stream(br.readLine().split(" "))
							mapToInt(Integer::parseInt).toArray();
			
			List<Integer> nums = Arrays.stream(br.readLine().split(" "))
						.map(Integer::parseInt).collect(Collectors.toList());
						
		- .filter() 
		
			- int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
					.filter(x -> x > 0).toArray();
		
		- .sorted() 
		
			- nums = nums.stream().sorted((a,b) -> b.compareTo(a)).collect(Collectors.toList());
				- order in descending 
				
			- Sorting Collections by Multiple Criteria
			
				-var products = new HashMap<int, string>();
				products.entrySet()
				.stream()
				.sorted((e1, e2) -> {
				int res = e2.getValue().compareTo(e1.getValue());
					if (res == 0)
					res = e1.getKey().compareTo(e2.getKey());
					return res;})
				.forEach(e -> System.out.println(e.getKey() + " " + e.getValue());

			- Sorting Collections to new Map
			
				- keyMaterials.entrySet().stream()
				.sorted((a,b)->b.getValue().compareTo(a.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
			
	
	