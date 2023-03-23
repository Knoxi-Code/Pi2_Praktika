public class ChildStack extends Stack{
    public ChildStack(int stackSize,int startValue){
        super(stackSize);
        for(int i = 0; i<stackSize;i++){//run through the whole Array
            push(startValue);
            startValue++;
        }
    }

    public boolean stackEmpty(){
        return top == -1;
    }

    public int push(int[] p){
        if(top+p.length < stack.length){//check weather p fits in the stack
            for(int i: p){
                push(i);
            }
            return 0;
        }
        else{
            return -1;
        }
    }
}
