class pascalTriangleRow {
    List<Integer> out = new ArrayList<>();
    public List<Integer> getRow(int rowIndex) {
        out.add(1);
        if (rowIndex == 0) return out;
        out.add(1);
        if (rowIndex == 1) return out;

        for (int i = 0; i<rowIndex ; i++) {
            int a = out.get(0), b=out.get(1);
            //System.out.println("a: "+ a +", b: "+b);
            for (int j = 1; j<i+1; j++) {
                
                out.set(j,a+b);
                //System.out.println(a+b);
                a = b;
                if(j+1<out.size()) b = out.get(j+1);
                
            }
            out.add(1);
        }
        out.remove(out.size()-1);
        return out;
    }
}