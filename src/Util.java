import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Util {
    // Vi

    public String getMerkleRoot(ArrayList<String> lstItems) {
        MerkleNode oNode1 = new MerkleNode();
        MerkleNode oNode2 = new MerkleNode();
        MerkleNode oNode3 = new MerkleNode();
        MerkleNode oNode4 = new MerkleNode();
        MerkleNode oNode5 = new MerkleNode();
        MerkleNode oNode6 = new MerkleNode();
        MerkleNode oNode7 = new MerkleNode();

        oNode1.sHash = generateHash(lstItems.get(0));
        oNode2.sHash = generateHash(lstItems.get(1));
        oNode3.sHash = generateHash(lstItems.get(2));
        oNode4.sHash = generateHash(lstItems.get(3));

        populateMerkleNode(oNode5, oNode1, oNode2);
        populateMerkleNode(oNode6, oNode3, oNode4);
        populateMerkleNode(oNode7, oNode5, oNode6);

        return oNode7.sHash;
    }

    private void populateMerkleNode(MerkleNode oNode, MerkleNode oLeftNode, MerkleNode oRightNode) {

        oNode.oLeft = oLeftNode;
        oNode.oRight = oRightNode;
        oNode.sHash = generateHash(oNode.oLeft.sHash + oNode.oRight.sHash);
    }

    public synchronized String generateHash(String sOriginal) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] btEncodedhash = digest.digest(
                    sOriginal.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < btEncodedhash.length; i++) {
                sb.append(Integer.toString((btEncodedhash[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception ex) {

            System.out.println("Error generating hash: " + ex.getMessage());
            return null;
        }
    }

    public String promptUser(String sQuestion) {
        JOptionPane oQuestion = new JOptionPane();
        String sAnswer = oQuestion.showInputDialog(sQuestion);
        return sAnswer;
    }

    public void sleepRandomTime(String sThreadName) {
        SecureRandom oSecureRandom = new SecureRandom();
        int iNum = oSecureRandom.nextInt(6) + 3;

        System.out.println(sThreadName + "is going to sleep for " + iNum + " seconds");
        Util.sleep(iNum);
    }

    public static void sleep(int iSeconds) {
        try {
            Thread.sleep(iSeconds * 1000);
        } catch(Exception e) {
        }
    }
}
