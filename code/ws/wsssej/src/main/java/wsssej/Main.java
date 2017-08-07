package wsssej;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class Main {
  public static void main(String[] args) throws Exception {
    Server svr = new Server(8080);
    WebAppContext ctx = new WebAppContext();
    ctx.setConfigurations(new Configuration[] {
      new AnnotationConfiguration(),
      new WebXmlConfiguration(),
      new WebInfConfiguration(),
      new FragmentConfiguration(),
      new EnvConfiguration(),
      new PlusConfiguration()
    });
    ctx.setContextPath("/");
    // ↓ssej のコードをアプリのクラスパスに追加
    ctx.setExtraClasspath("./");
    // ↓静的コンテンツはクラスパスの public 配下に置く
    ctx.setBaseResource(
      Resource.newClassPathResource("/public")
    );
    svr.setHandler(ctx);
    svr.start();
    svr.join();
  }
}
