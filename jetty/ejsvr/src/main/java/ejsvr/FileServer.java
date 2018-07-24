package ejsvr;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;

public class FileServer {
  public static void main(String[] args) throws Exception {
    Server svr = new Server(8080);
    ResourceHandler rhand = new ResourceHandler();
    rhand.setDirectoriesListed(false);
    rhand.setBaseResource(
      Resource.newClassPathResource("/public")
    );
    svr.setHandler(rhand);
    svr.start();
    svr.join();
  }
}
