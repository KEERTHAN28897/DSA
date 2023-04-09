class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        Map<String,List<Transaction>> userMap = new HashMap();
        List<String> invalidTrans = new ArrayList();
        for(int i = 0; i < transactions.length; i++){
            //Mapping user and list of transactions and updating
            //invalidTrans list if any transaction has amount > 1000
            mapUserAndTransaction(userMap,transactions[i],invalidTrans);
        }
        for(String key : userMap.keySet()){
            // for each user check if there are any transactions
            // that are overlapping within 60 mins and has different 
            // cities
            checkAndUpdateInvalidTrans(userMap.get(key),invalidTrans);
        }
        return invalidTrans;
    }

    void checkAndUpdateInvalidTrans(List<Transaction> transactions,List<String> invalidTrans){
        for(Transaction tr : transactions){
            if(!tr.isValid)continue;//ignore if transaction is marked invalid
          for(Transaction ts : transactions){
              if(tr.city.equals(ts.city))continue;// ignore if cities are same
              if(Math.abs(tr.time-ts.time) <= 60){
                  tr.isValid = false;
                  invalidTrans.add(tr.getString());
                  if(ts.isValid){// check and mark other transaction as invalid
                      ts.isValid = false;
                      invalidTrans.add(ts.getString());
                  }
                  break;//no need to check against other transactions
              }
          }
        }
    }

    void mapUserAndTransaction(Map<String,List<Transaction>> userMap,String in,List<String> invalidTrans){
        String[] arr = in.split(",");
        Transaction tr = new Transaction(
            arr[0],
            Integer.parseInt(arr[1]),
            arr[3],
            Integer.parseInt(arr[2])
        );
        userMap.putIfAbsent(arr[0],new ArrayList<Transaction>());
        userMap.get(arr[0]).add(tr);
        if(!tr.isValid){
            invalidTrans.add(tr.getString());
        }
    }
}

class Transaction{
    int time, amount;
    String city,name;
    boolean isValid = true;

    Transaction(String name,int time,String city,int amount){
        this.time = time;
        this.name = name;
        this.city = city;
        this.amount = amount;
        if(amount > 1000){
            isValid = false;
        }
    }

    // returns the string in actual format
    String getString(){
        return String.format("%s,%d,%d,%s",name,time,amount,city);
    }
}