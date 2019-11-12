package semesterprojekt1;

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), INTERACT("interact"), TAKE("take"), OPEN("open"), INFO("info");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    @Override
    public String toString()
    {
        return commandString;
    }
}
