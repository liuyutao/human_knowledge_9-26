package com.allin.knowledge.util;

import java.io.Writer;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.mapper.DefaultMapper;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.mapper.XStream11XmlFriendlyMapper;


public class MessageUtil {

//	/**
//	 * 解析微信发来的请求（XML）
//	 * 
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	@SuppressWarnings("unchecked")
//	public static Map<String, String> parseXml(String msg)
//			throws Exception {
//		// 将解析结果存储在HashMap中
//		Map<String, String> map = new HashMap<String, String>();
//
//		// 从request中取得输入流
//		InputStream inputStream = new ByteArrayInputStream(msg.getBytes("UTF-8"));
//		
//		// 读取输入流
//		SAXReader reader = new SAXReader();
//		Document document = reader.read(inputStream);
//		// 得到xml根元素
//		Element root = document.getRootElement();
//		// 得到根元素的所有子节点
//		List<Element> elementList = root.elements();
//
//		// 遍历所有子节点
//		for (Element e : elementList)
//			map.put(e.getName(), e.getText());
//
//		// 释放资源
//		inputStream.close();
//		inputStream = null;
//
//		return map;
//	}

    /**
     * 文本消息对象转换成xml
     *
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String textMessageToXml(Object textMessage) {
        xstream.alias("xml", Map.class);

        String message = xstream.toXML(textMessage);
        return message.replace("__", "_");
    }

    public void aaa() {

    }

    /**
     * 扩展xstream，使其支持CDATA块
     *
     * @date 2013-05-19
     */
    private static XStream xstream = new XStream(new XppDriver() {
        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @Override
                @SuppressWarnings("rawtypes")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                @Override
                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });


    static {
        xstream.registerConverter(new MessageUtil().new MapCustomConverter(new DefaultMapper(XStream11XmlFriendlyMapper.class.getClassLoader())));
    }


    /**
     * @author fuliang
     */
    public class MapCustomConverter extends AbstractCollectionConverter {

        /**
         * @param mapper
         */
        public MapCustomConverter(Mapper mapper) {
            super(mapper);
        }

        public boolean canConvert(Class type) {
            return type.equals(HashMap.class)
                    || type.equals(Hashtable.class)
                    || type.getName().equals("java.util.LinkedHashMap")
                    || type.getName().equals("sun.font.AttributeMap") // Used by java.awt.Font in JDK 6
                    ;
        }

        public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
            Map map = (Map) source;
            for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
                Entry entry = (Entry) iterator.next();
//            ExtendedHierarchicalStreamWriterHelper.startNode(writer, "property", Entry.class);  
                ExtendedHierarchicalStreamWriterHelper.startNode(writer, entry.getKey().toString(), Entry.class);

//            writer.addAttribute("key",  entry.getKey().toString()); 
                String entryValue = entry.getValue() == null ? "" : entry.getValue().toString();

                writer.setValue(entryValue);
//            writer.addAttribute("value", entry.getValue().toString());  
                writer.endNode();
            }
        }

        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            Map map = (Map) createCollection(context.getRequiredType());
            populateMap(reader, context, map);
            return map;
        }

        protected void populateMap(HierarchicalStreamReader reader, UnmarshallingContext context, Map map) {
            while (reader.hasMoreChildren()) {
                reader.moveDown();
                Object key = reader.getAttribute("key");
                Object value = reader.getAttribute("value");
                map.put(key, value);
                reader.moveUp();
            }
        }
    }
}