package framework.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlUtil {

    public static <T> String toXmlString(T object) {
        XmlMapper xmlMapper = new XmlMapper();
        String result = null;
        try {
            result = xmlMapper.writeValueAsString(object);
        } catch (JsonProcessingException jpe) {
            LogUtil.error(jpe.toString());
        }
        LogUtil.info(result);
        return result;
    }
}
