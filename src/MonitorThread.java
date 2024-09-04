public class MonitorThread implements Runnable {
    public run() {
        Util oUtil = new Util();
        while (true) {
            if (MerkleManager.merkleRoot != null) {
                if (MerkleManager.merkleRoot = MerkleManager.userInput;) {
                    System.out.println("You win " + MerkleManager.merkleRoot);
                    break;
                } else {
                    System.out.println("You lost " + MerkleManager.merkleRoot);
                    System.exit(0);
                }
            } else if (MerkleManager.strikes == 3) {
                System.out.println("3 strikes: you lost!");
                System.exit(0);
            }
            oUtil.sleep(1);
        }
    }
}
