package jp.yucchi.girlfriends;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yucchi
 */
public class GirlFriends {

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> girlFriends = new CopyOnWriteArrayList<>();

        girlFriends.add("堀北真希");

        GirlFriends_1 girlFriend_1 = new GirlFriends_1(girlFriends);
        GirlFriends_2 girlFriend_2 = new GirlFriends_2(girlFriends);

        CompletableFuture<CopyOnWriteArrayList<String>> girls_1 = CompletableFuture.supplyAsync(() -> girlFriend_1.updateGirlFriend());
        CompletableFuture<CopyOnWriteArrayList<String>> girls_2 = CompletableFuture.supplyAsync(() -> girlFriend_2.updateGirlFriend());

        CompletableFuture<Void> allTask = CompletableFuture.allOf(girls_1, girls_2);
        allTask.join();

        girlFriends.add("綾瀬はるか");

        if (allTask.isDone()) {
            try {
                System.out.println("GirlFriend_1 List");
                girls_1.get().forEach(System.out::println);
                System.out.println("GirlFriend_2 List");
                girls_2.get().forEach(System.out::println);
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(GirlFriends.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            TimeUnit.MILLISECONDS.sleep(1_000);
            girlFriends.add("新垣結衣");
            girlFriends.add("剛力彩芽");
        } catch (InterruptedException ex) {
            Logger.getLogger(GirlFriends_1.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("GirlFriend List");
        girlFriends.forEach(System.out::println);
    }

}
