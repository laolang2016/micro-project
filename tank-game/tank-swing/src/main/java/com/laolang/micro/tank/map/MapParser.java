package com.laolang.micro.tank.map;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.laolang.micro.tank.consts.GameConsts;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

@Slf4j
@UtilityClass
public class MapParser {

    private static final String TILED_MEPTY = "0";
    private static final String TILED_NOT_MEPTY = "1";
    private static final String LAYER_ID_ATTR_NAME = "id";

    private static final Map<String, String> tiledXpathMap = Maps.newHashMap();
    private static final Map<String, BufferedImage> tiledImageMap = Maps.newHashMap();

    static {
        tiledXpathMap.put(GameConsts.TILED_NAME_BRICK, GameConsts.MAP_XPATH_BRICK);
        tiledXpathMap.put(GameConsts.TILED_NAME_STONE, GameConsts.MAP_XPATH_STONE);

        tiledImageMap.put(GameConsts.TILED_NAME_BRICK, GameConsts.TILED_IMAGE_BRICK);
        tiledImageMap.put(GameConsts.TILED_NAME_STONE, GameConsts.TILED_IMAGE_STONE);
    }

    /**
     * 解析地图数据
     *
     * @param level 关卡
     * @return 底数数据
     * @see Tiled
     */
    public static List<Tiled> parse(String level) {
        Document document = getRootDocument(level);
        Element rootElement = document.getRootElement();

        List<Tiled> tileds = Lists.newArrayList();

        tiledXpathMap.forEach((brickName, xpath) -> {
            List<Tiled> brickList = parseTiled(rootElement, xpath, brickName);
            if (CollUtil.isNotEmpty(brickList)) {
                tileds.addAll(brickList);
            }
        });

        if (CollUtil.isEmpty(tileds)) {
            throw new RuntimeException("地图数据不存在");
        }
        return tileds;
    }

    /**
     * 解析瓦片 layer
     *
     * @param root      xml 根节点
     * @param xpath     layer->data 对应的 xpath
     * @param tiledName 瓦片 layer 名称
     * @return 瓦片数据集合
     */
    private List<Tiled> parseTiled(Element root, String xpath, String tiledName) {
        List<Tiled> tileds = Lists.newArrayList();
        LayerCsvModel layerData = getTiledCsvData(root, xpath);
        if (Objects.isNull(layerData)) {
            return tileds;
        }
        String brickCsvData = StrUtil.replace(layerData.getData(), "\n", "");
        List<String> dataList = StrUtil.split(brickCsvData, ",");
        int size = GameConsts.TILED_MAP_WITDH;

        String[][] dataArray = new String[size][size];
        for (int i = 0; i < dataList.size(); i++) {
            String data = dataList.get(i);
            dataArray[i / size][i % size] = data;
        }

        for (int i = 0; i < dataArray.length; i++) {
            for (int j = 0; j < dataArray[i].length; j++) {
                String data = dataArray[i][j];
                if (!hasTiled(data)) {
                    continue;
                }

                int x = j * GameConsts.TILED_WIDTH + GameConsts.MAP_START_X;
                int y = i * GameConsts.TILED_WIDTH + GameConsts.MAP_START_Y;
                tileds.add(new Tiled(x, y, tiledName, tiledImageMap.get(tiledName), Integer.valueOf(layerData.getId())));
            }
        }
        return tileds;
    }

    /**
     * 瓦片坐标是否有地图数据
     */
    private static boolean hasTiled(String data) {
        return !StrUtil.equals(data, TILED_MEPTY);
    }

    /**
     * 获取 layer 数据集
     *
     * @param root  xml 根节点
     * @param xpath layer->data 对应的 xpath
     * @return cxv 数据
     */
    private static LayerCsvModel getTiledCsvData(Element root, String xpath) {
        Node node = root.selectSingleNode(xpath);
        if (Objects.isNull(node)) {
            return null;
        }
        Element parent = node.getParent();
        return new LayerCsvModel(parent.attributeValue(LAYER_ID_ATTR_NAME), node.getText());
    }

    /**
     * 获取根节点
     *
     * @param level 关卡
     */
    private static Document getRootDocument(String level) {
        String map = StrUtil.format("/tiled/{}.tmx", level);
        log.info("加载地图:{}", map);
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(MapParser.class.getResource(map));
        } catch (DocumentException e) {
            log.info("加载地图出错:{}", ExceptionUtils.getMessage(e));
            throw new RuntimeException(e);
        }
        return document;
    }
}

