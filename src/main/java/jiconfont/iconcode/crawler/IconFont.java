package jiconfont.iconcode.crawler;

/**
 * Copyright (c) 2016 jIconFont <BR>
 * <BR>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:<BR>
 * <BR>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.<BR>
 * <BR>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public enum IconFont {

    ENTYPO("https://raw.github.com/danielbruce/entypo/master/font/entypo.css", "E_", EntypoCrawler.class),
    ELUSIVE("https://raw.github.com/reduxframework/elusive-iconfont/master/less/variables.less", "E_", ElusiveCrawler.class),
    MFG_LABS("https://raw.github.com/MfgLabs/mfglabs-iconset/master/css/mfglabs_iconset.css", "M_", MFGLabsCrawler.class),
    OPEN_ICONIC("https://raw.github.com/somerandomdude/Iconic/master/font/Iconic%20Fill/iconic_fill.css.scss", "I_", OpenIconicCrawler.class),
    GOOGLE_MATERIAL_DESIGN_ICONS("https://raw.github.com/google/material-design-icons/master/iconfont/codepoints", "G_", GoogleMaterialDesignIconsCrawler.class),
    FONT_AWESOME("https://raw.github.com/FortAwesome/Font-Awesome/master/src/icons.yml", "FA_", FontAwesomeCrawler.class);

    IconFont(String url, String prefix, Class<? extends Crawler> crawlerClass) {
        this.url = url;
        this.prefix = prefix;
        this.crawlerClass = crawlerClass;
    }

    private String url;
    private String prefix;
    private Class<? extends Crawler> crawlerClass;

    public String getUrl() {
        return url;
    }

    public String getPrefix() {
        return prefix;
    }

    public Crawler buildCrawler() throws IllegalAccessException, InstantiationException {
        return crawlerClass.newInstance();
    }
}
