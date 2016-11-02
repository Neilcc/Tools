[problemUrl](https://www.careercup.com/question?id=5659801074794496)

```
class a {

    int find(List b){
        int total =0;
        if(b == null || b.size() ==0 || b.get(0) == 0){
            return 0;
        }
        if(b.size()== 1){
            return 1;
        }
        List c = b.clone;
        c.remove(0);
        total + = find(c);
        if(b.get(0) * 10 + b.get(1) <= 26){
            total + = find (c);
        }
        return total;
    }

    int [] main (){
        int totoal = find (input);
    }
}

```
