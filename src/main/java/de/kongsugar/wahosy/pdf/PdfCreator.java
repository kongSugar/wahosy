package de.kongsugar.wahosy.pdf;

import com.lowagie.text.DocumentException;
import org.apache.ibatis.io.Resources;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * NOT IMPLEMETED YET
 */
public class PdfCreator {

    public static void main(String[] args) throws IOException, DocumentException {
        Path o = Paths.get("Test.pdf");
        ITextRenderer renderer = new ITextRenderer();

        OutputStream os = Files.newOutputStream(o);
        renderer.setDocument(Resources.getResourceAsFile("sample.xhtml"));
        //renderer.setDocument("sample.xhtml");
        renderer.layout();
        renderer.createPDF(os);
        os.close();
    }
}
