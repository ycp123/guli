import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.client.JenkinsHttpClient;
import com.offbytwo.jenkins.model.Build;
import com.offbytwo.jenkins.model.BuildWithDetails;
import com.offbytwo.jenkins.model.JobWithDetails;
import com.offbytwo.jenkins.model.QueueItem;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author yangchunping
 * @date 2022/6/1 3:02 下午
 */
public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        JenkinsServer server = new JenkinsServer(new URI("http://10.2.10.2:8080/"), "yangchunping", "During-assembly-67-tips");

        JobWithDetails testBuild = server.getJob("testBuild");
        JobWithDetails details2 = testBuild.details();
        BuildWithDetails details1 = testBuild.getBuildByNumber(466).details();
        String s = details1.getClient().get("/job/app%20build/7181/wfapi/describe");
        List actions = details1.getActions();
        QueueItem queueItem = testBuild.getQueueItem();
        details2.build().getQueueItemUrlPart()
        JobWithDetails details = testBuild.details();
        testBuild.getAllBuilds();
    }
}
