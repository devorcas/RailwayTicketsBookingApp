package custom.tag;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class InfoTimeTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {

        GregorianCalendar gc = new GregorianCalendar();
        String time = "<hr/>Time: <b> " + gc.getTime() + " </b><hr/>";
        String locale = "Locale : <b> " + Locale.getDefault() + " </b><hr/>";
        try {
            JspWriter out = pageContext.getOut();
            out.write(time + locale);
        } catch (IOException ex) {
            Logger.getLogger(InfoTimeTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

}
