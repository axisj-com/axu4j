package com.axisj.axu4j.tags;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Map;

/**
 * Created by HJ.Park on 2015-02-08.
 */
public class WriteTag extends SimpleTagSupport {

    private Logger logger = LoggerFactory.getLogger(WriteTag.class);

    public WriteTag() throws Exception {
        super();
    }

    private String divname;

    public String getDivname() {
        return divname;
    }

    public void setDivname(String divname) {
        this.divname = divname;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) getJspContext();
        Map divMap = (Map) pageContext.getRequest().getAttribute("divMap");
        String divValue;

        if (divMap == null || !divMap.containsKey(divname)) {
            // if not exist divname write default
            divValue = TagUtils.toString(getJspBody());
        } else {
            divValue = ObjectUtils.toString(divMap.get(divname));
        }

        if (StringUtils.isNotBlank(divValue)) {
            getJspContext().getOut().write(divValue);

            if (logger.isDebugEnabled()) {
                logger.debug("div#{} writed", divname);
            }
        }

    }
}
