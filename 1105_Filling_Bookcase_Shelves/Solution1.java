class Solution1 {
    public static int minHeightShelves(int[][] books, int shelfWidth) {
        int i = 0;
        int height = 0;

        while (i < books.length) {
            int levelWidth = 0;
            int levelHeight = books[i][1];
            while (i < books.length && levelWidth + books[i][0] < shelfWidth) {
                levelHeight = books[i][1] > levelHeight? books[i][1] : levelHeight;
                levelWidth += books[i][0];
                i++;
            }

            height += levelHeight;
        }
        return height;
    }

    public static void main(String[] args) {
        int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelfWidth = 4;
        System.out.println("\noutput = " + minHeightShelves(books, shelfWidth));
    }
}