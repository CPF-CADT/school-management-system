public class DOB {
    private int day;
    private int month;
    private int year;
   DOB(){
      day=0;
      month=0;
      year=0;
   }
    DOB(String date){
        // date
    }
    DOB(int day,int month,int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
