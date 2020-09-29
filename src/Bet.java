public class Bet<object> {

    object value;
    float amount;

    public Bet(String[] args) throws IllegalAccessException {
        if(args.length == 2){
            this.setValue(args[0]);
            this.setAmount(args[1]);
        }else{
            throw new IllegalArgumentException("\"Invalid values entered: \" + String.join(\" \", args)");
        }
    }

    void setValue(String val) throws IllegalAccessException{
        try{
            int betVal = Integer.parseInt(val);

            if(betVal >= 1 && betVal <= 36)
               this.value =betVal;
            else
                throw new IllegalArgumentException(String.format("Value %s is an invalid bet!",val));
        }catch(Exception ignored){
            if(val.equalsIgnoreCase("even") || val.equalsIgnoreCase("odd")){
                this.value= val;
            }else{
                throw new IllegalArgumentException(String.format("Value %s is an invalid bet!", val));
            }
        }
    }

    void setAmount(String val) throws NumberFormatException{
        this.amount = Float.parseFloat(val);
    }

}
