public interface chess{
    public void start();
    public void end();
    public void move(String pawn, String place);
    public void change(String pawn, String place, String[][] changeboard);
    public String winner();
    public Boolean possible(String pawn, String place);
    public void gettingdata();
}