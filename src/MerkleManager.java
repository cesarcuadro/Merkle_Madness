import java.util.Scanner;

public class MerkleManager {
    public static volatile String userInput;
    public static String expectedUserOutput;
    public static String merkleRoot = null;
    public static int strikes = 0;

    public void manage() {
        Util oUtil = new Util();
        System.out.print("What do you expect to output?: ");
        expectedUserOutput = oUtil.promptUser("What do you expect to output?: ");


        MerkleThread oMerkleThread = new MerkleThread();
        RogueThread oRogueThread = new RogueThread();
        MonitorThread oMonitorThread = new MonitorThread();

        Thread merkleThread = new Thread(oMerkleThread);
        Thread rogueThread = new Thread(oRogueThread);
        Thread monitorThread = new Thread(oMonitorThread);

        merkleThread.start();
        rogueThread.start();
        monitorThread.start();

        while (true) {
            System.out.print("Input your guess: ");
            userInput = oUtil.promptUser("Input your guess: ");
        }
    }

    public static synchronized String grabWord() {
        String tempString;
        tempString = userInput;
        userInput = null;
        return tempString;
    }
}
