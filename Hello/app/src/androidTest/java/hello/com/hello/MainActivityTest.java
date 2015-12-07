package hello.com.hello;

import android.test.AndroidTestCase;

import org.mockito.Mockito;

import java.util.List;

/**
 * Created by kongfei on 11/25/15.
 */
public class MainActivityTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.setProperty("dexmaker.dexcache", getContext().getCacheDir().getPath());
    }

    public void testMockito() {
        List mockedList = Mockito.mock(List.class);

        mockedList.add("one");
        mockedList.clear();

        System.out.println("test ok");

        Mockito.verify(mockedList).add("one");
        Mockito.verify(mockedList).clear();

    }

    /**
     * 参数匹配
     */
    public void testWithArguments(){
        Comparable comparable = Mockito.mock(Comparable.class);
        //预设根据不同的参数返回不同的结果
        Mockito.when(comparable.compareTo("Test")).thenReturn(1);
        Mockito.when(comparable.compareTo("Omg")).thenReturn(2);
        assertEquals(1, comparable.compareTo("Test"));
        assertEquals(2, comparable.compareTo("Omg"));
        //对于没有预设的情况会返回默认值
        assertEquals(0, comparable.compareTo("Not stub"));
    }

    public void testString() {

        String s = "xx";

    }


}
