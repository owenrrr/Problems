List<Edge> list = new ArrayList<>();
list.add(new Edge(0,1));
list.add(new Edge(1,2));
list.add(new Edge(2,0));
list.add(new Edge(2,3));
list.add(new Edge(3,4));
list.add(new Edge(4,5));

Solve solve = new Solve();
solve.run(6, 6, list);