package com.zhao.www.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhao.www.dao.ICharDataDao;
import com.zhao.www.dao.impl.CharDataDaoImpl;
import com.zhao.www.entity.Resource;
import com.zhao.www.util.Log;

/**
 * Servlet implementation class JsonDataSvl
 */
@WebServlet("/JsonDataSvl")
public class JsonDataSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JsonDataSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("uft-8");
		response.setContentType("text/html;charset=utf-8");
		ICharDataDao chardao = new CharDataDaoImpl();
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		try {
			for (int a = 0; a <= Resource.LINK; a++) {
				int size = chardao.getData(a);
				array.add(size);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.logger.error("��ѯ���������Ǳ��������ǣ�" + e.getMessage());
		}
		obj.put("num", array);
		System.out.println(obj);
		JSONArray array1 = new JSONArray();
		String[] arr = { "��Ƶ", "ͼ��", "ͼ��", "����", "����" };
		array1.add("��Ƶ");
		array1.add("ͼ��");
		array1.add("ͼ��");
		array1.add("����");
		array1.add("����");
		obj.put("leixin", array1);
		PrintWriter pw = response.getWriter();
		System.out.println(obj);
		pw.print(obj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
