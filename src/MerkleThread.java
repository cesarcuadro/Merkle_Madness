import java.util.ArrayList;

public class MerkleThread implements Runnable {
    public static volatile ArrayList<String> lstWords;
    private int iMerkleTreeInputs = 4;

    public void run() {
        Util objUtil = new Util();
        lstWords = new ArrayList<>();
        MerkleManager objMerkleManager = new MerkleManager();

        while (true) {
            objUtil.sleepRandomTime("MerkleThread");
            String sNewWord = MerkleManager.grabWord();
            if (sNewWord != null) {
                System.out.println("Merkle grabbed a new word");
                lstWords.add(sNewWord);
                if (lstWords.size() == iMerkleTreeInputs) {
                    MerkleManager.merkleRoot = objUtil.getMerkleRoot(lstWords);
                }
            }
        }
    }
}
