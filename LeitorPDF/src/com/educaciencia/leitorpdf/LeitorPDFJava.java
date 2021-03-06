package com.educaciencia.leitorpdf;

import java.io.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.util.*;

public class LeitorPDFJava {
	/**
	 * Baixar ultima versao do PDFBox - https://downloads.apache.org/pdfbox/3.0.0-RC1/pdfbox-app-3.0.0-RC1.jar
	 * Baixar Versoes Anteriores https://archive.apache.org/dist/pdfbox/1.5.0/
	 * 
	 * Voc? deve validar o ClassPath, para isso acesse Propriedades, Project, Add e referencie o Projeto
	 * Voc? deve adicionar o Jar do PDFBox, para isso acesse Propiedades, Library, Add External Jar e aponte para o jar do PDFBox baixado
	 */
	public static String extraiTextoDoPDF(String dadosLer) {
		PDDocument documentoPDF = null;
		try {
			documentoPDF = PDDocument.load(dadosLer);
			PDFTextStripper stripper = new PDFTextStripper();
			String texto = stripper.getText(documentoPDF);
			return texto;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (documentoPDF != null)
				try {
					documentoPDF.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
		}
	}

	public static void main(String[] args) {
		
		String arquivo = "TestePDF.pdf"; //criamos um arquivo PDF , pelo WORD salvamos arquivo com extens?o PDF para teste, mas voc? pode apontar para seu documento com extens?o PDF
		String caminho = "C:\\EclipseDemo\\LeitorPDF\\pdfArquivo\\";
		
		String dadosLer = caminho + arquivo;
		String arquivoConvertidoJava = extraiTextoDoPDF(dadosLer);
		
		System.out.println(arquivoConvertidoJava);
	}
}