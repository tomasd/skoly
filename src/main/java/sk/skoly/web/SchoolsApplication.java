package sk.skoly.web;

import javax.servlet.ServletContext;

import net.databinder.hib.DataApplication;
import net.databinder.hib.HibernateApplication;

import org.apache.wicket.Page;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.event.PreInsertEvent;
import org.hibernate.event.PreInsertEventListener;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

import sk.skoly.interceptors.AuditInterceptor;
import sk.skoly.model.Entita;
import sk.skoly.model.HodinovaSadzbaLektora;
import sk.skoly.model.HodinovaSadzbaNakladovejSkupiny;
import sk.skoly.model.Kurz;
import sk.skoly.model.Lekcia;
import sk.skoly.model.Lektor;
import sk.skoly.model.MesacnyNakladVyucovacichMiest;
import sk.skoly.model.NakladovaSkupina;
import sk.skoly.model.Platca;
import sk.skoly.model.Pouzivatel;
import sk.skoly.model.Prezencka;
import sk.skoly.model.SkupinaVyucovacichMiest;
import sk.skoly.model.Student;
import sk.skoly.model.UcastnikKurzu;
import sk.skoly.model.UcastnikLekcie;
import sk.skoly.model.VyucovacieMiesto;
import sk.skoly.model.ZmluvaLektora;
import sk.skoly.web.pages.MainPage;

public class SchoolsApplication extends DataApplication implements HibernateApplication {

	@Override
	protected void init() {
		super.init();
		// mountBookmarkablePage("/", TitlePage.class);
		// mount(new MixedParamUrlCodingStrategy("building", BuildingPage.class,
		// new String[]{"id"}));
		// mount(new QueryStringUrlCodingStrategy("building",
		// BuildingListPage.class));
		// mount(new QueryStringUrlCodingStrategy("/company/",
		// CompanyListPage.class));
		// mount(new QueryStringUrlCodingStrategy("/course/",
		// CourseListPage.class));
		// mount(new QueryStringUrlCodingStrategy("/lector/",
		// LectorListPage.class));
		// mount(new QueryStringUrlCodingStrategy("/student/",
		// StudentListPage.class));
		// mount(new QueryStringUrlCodingStrategy("/test/",
		// TestListPage.class));
		getMarkupSettings().setStripWicketTags(true);
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return MainPage.class;
	}

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);

		WebAppContext context = new WebAppContext();
		context.setWar("src/main/webapp");
		context.setContextPath("/");
		context.setParentLoaderPriority(true);
		server.addHandler(context);

		server.start();
	}

	/**
	 * Configures the default session factory; override to add annotated classes
	 * but don't forget to call this super-implementation if you want its
	 * defaults. When running in development the session factory is set for
	 * hbm2ddl auto-updating to create and add columns to tables as required.
	 * For deployment it is configured for C3P0 connection pooling.
	 * 
	 * @param config
	 *            used to build Hibernate session factory
	 */
	protected void configureHibernate(AnnotationConfiguration config) {
		java.net.URL url = getClass().getResource("/hibernate.cfg.xml");
		config.setInterceptor(new AuditInterceptor());
		config.configure(url);
		config.addAnnotatedClass(Entita.class);
		config.addAnnotatedClass(HodinovaSadzbaLektora.class);
		config.addAnnotatedClass(HodinovaSadzbaNakladovejSkupiny.class);
		config.addAnnotatedClass(Kurz.class);
		config.addAnnotatedClass(Lekcia.class);
		config.addAnnotatedClass(Lektor.class);
		config.addAnnotatedClass(MesacnyNakladVyucovacichMiest.class);
		config.addAnnotatedClass(NakladovaSkupina.class);
		config.addAnnotatedClass(Platca.class);
		config.addAnnotatedClass(Pouzivatel.class);
		config.addAnnotatedClass(Prezencka.class);
		config.addAnnotatedClass(SkupinaVyucovacichMiest.class);
		config.addAnnotatedClass(Student.class);
		config.addAnnotatedClass(UcastnikKurzu.class);
		config.addAnnotatedClass(UcastnikLekcie.class);
		config.addAnnotatedClass(VyucovacieMiesto.class);
		config.addAnnotatedClass(ZmluvaLektora.class);
		config.setListener("pre-insert", new PreInsertEventListener() {
			
			@Override
			public boolean onPreInsert(PreInsertEvent event) {
				return false;
			}
		});
		super.configureHibernate(config);
	}

}
