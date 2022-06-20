package google;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//https://leetcode.com/explore/interview/card/google/67/sql-2/3044/
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (String email : emails) {
            if (set.contains(email)) continue;
            int plusCount = 0;
            builder.setLength(0);
            for (int i = 0; ; i++) {
                char ch = email.charAt(i);
                if (ch == '@') {
                    builder.append(email.substring(i));
                    break;
                }
                if (ch == '.') continue;
                if (ch == '+') { plusCount++; continue; }
                if (plusCount > 0) continue;
                builder.append(ch);
            }
            set.add(builder.toString());
        }
        return set.size();
    }

    @Test
    public void test() {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        Assert.assertEquals(2, numUniqueEmails(emails));
    }

    @Test
    public void test2() {
        String[] emails = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        Assert.assertEquals(3, numUniqueEmails(emails));
    }

    @Test
    public void test3() {
        String[] emails = {
                "fg.r.u.uzj+o.pw@kziczvh.com",
                "r.cyo.g+d.h+b.ja@tgsg.z.com",
                "fg.r.u.uzj+o.f.d@kziczvh.com",
                "r.cyo.g+ng.r.iq@tgsg.z.com",
                "fg.r.u.uzj+lp.k@kziczvh.com",
                "r.cyo.g+n.h.e+n.g@tgsg.z.com",
                "fg.r.u.uzj+k+p.j@kziczvh.com",
                "fg.r.u.uzj+w.y+b@kziczvh.com",
                "r.cyo.g+x+d.c+f.t@tgsg.z.com",
                "r.cyo.g+x+t.y.l.i@tgsg.z.com",
                "r.cyo.g+brxxi@tgsg.z.com",
                "r.cyo.g+z+dr.k.u@tgsg.z.com","r.cyo.g+d+l.c.n+g@tgsg.z.com","fg.r.u.uzj+vq.o@kziczvh.com","fg.r.u.uzj+uzq@kziczvh.com","fg.r.u.uzj+mvz@kziczvh.com","fg.r.u.uzj+taj@kziczvh.com","fg.r.u.uzj+fek@kziczvh.com"
        };
        Assert.assertEquals(2, numUniqueEmails(emails));
    }

}
