public class RogueThread implements Runnable {

    public void run() {
        Util oUtil = new Util();
        while (true) {
            oUtil.sleepRandomTime("Rogue");
            String sNewWord = MerkleManager.grabWord();
            if (sNewWord != null) {
                MerkleManager.strikes++;
                System.out.println("Rogue grabbed a sword and mentioned \"STRIKE\"");
                }
        }

    }
}
