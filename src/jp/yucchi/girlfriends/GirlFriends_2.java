package jp.yucchi.girlfriends;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yucchi
 */
class GirlFriends_2 {

    private final CopyOnWriteArrayList<String> girlFriends;

    GirlFriends_2(CopyOnWriteArrayList<String> girlFriends) {
        this.girlFriends = girlFriends;
    }

    CopyOnWriteArrayList<String> updateGirlFriend() {
        Thread.currentThread().setName(" Girls_2");
        try {
            TimeUnit.MILLISECONDS.sleep(1_000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GirlFriends_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        girlFriends.remove("北川景子");
        girlFriends.remove("桐谷美玲");
        girlFriends.remove("新垣結衣");
        girlFriends.remove("剛力彩芽");

        girlFriends.forEach(e -> {
            System.out.println(e + Thread.currentThread().getName());
        });

        return girlFriends;
    }

}
