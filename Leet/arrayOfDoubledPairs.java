class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0)+1);
        }
        Arrays.sort(arr);
        //hashMap.put(12,0);
        int i = 0;
        while(i < arr.length){
            int key = arr[i];
            if(key<0){
                int  keyhalf = key/2;

                if(hashMap.containsKey(key)){
                    if(hashMap.containsKey(keyhalf)){
                        //Decrementing key if found
                        if(hashMap.get(key) == 1){
                            hashMap.remove(key);
                        }else{
                            hashMap.put(key, hashMap.get(key)-1);
                        }

                        //Decrementing Half Key
                        if(hashMap.get(keyhalf) == 1){
                            hashMap.remove(keyhalf);
                        }else{
                            hashMap.put(keyhalf, hashMap.get(keyhalf)-1);
                        }
                        i++;

                    }else{
                        return false;
                    }
                }else{
                    i++;
                    continue;
                }
            }else{
                //For Positive Values
                int keydouble = key*2;

                if(hashMap.containsKey(key)){
                    if(hashMap.containsKey(keydouble)){
                        //Decrementing key if found
                        if(hashMap.get(key) == 1){
                            hashMap.remove(key);
                        }else{
                            hashMap.put(key, hashMap.get(key)-1);
                        }

                        //Decrementing Half Key
                        if(hashMap.get(keydouble) == 1){
                            hashMap.remove(keydouble);
                        }else{
                            hashMap.put(keydouble, hashMap.get(keydouble)-1);
                        }
                        i++;

                    }else{
                        return false;
                    }
                }else{
                    i++;
                    continue;
                }
            }
        }
        
        System.out.println(hashMap.toString());
        return false;
    }
}