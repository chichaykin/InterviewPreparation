package leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class CanonicalPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] split = path.split("/");
        for(String s: split){
            if(s.equals("..") ) stack.poll();
            else if(!s.equals("") && !s.equals(".")) stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        if(stack.size() == 0) return "/";
        while(stack.size() != 0) sb.append("/").append(stack.pollLast());
        return sb.toString();
    }

    @Test
    public void test5() {
        assertEquals("/..hidden", simplifyPath("/..hidden"));
    }

    @Test
    public void test4() {
        assertEquals("/...", simplifyPath("/..."));
    }

    @Test
    public void test3() {
        assertEquals("/a/b/c", simplifyPath("/a//b////c/d//././/.."));
    }

    @Test
    public void test2() {
        assertEquals("/c", simplifyPath("/a/./b/../../c/"));
    }

    @Test
    public void test() {
        assertEquals("/home/foo", simplifyPath("/home//foo/"));
    }
}
