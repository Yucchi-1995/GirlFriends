package jp.yucchi.girlfriends;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yucchi
 */
class GirlFriends_1 {

    private final CopyOnWriteArrayList<String> girlFriends;

    GirlFriends_1(CopyOnWriteArrayList<String> girlFriends) {
        this.girlFriends = girlFriends;
    }

    CopyOnWriteArrayList<String> updateGirlFriend() {
        Thread.currentThread().setName(" Girls_1");
        girlFriends.add("北川景子");
        girlFriends.add("桐谷美玲");
        girlFriends.add("新垣結衣");
        girlFriends.add("剛力彩芽");

        girlFriends.forEach(e -> {
            System.out.println(e + Thread.currentThread().getName());
            try {
                TimeUnit.MILLISECONDS.sleep(1_000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GirlFriends_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        return girlFriends;

    }

}
