package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.EmployeeDAO;

/**
 * Servlet implementation class EmployeeRegist
 * @author Hideaki Yabe
 * 従業員新規登録クラス。
 */
@WebServlet("/RegistEmployee")
public class RegistEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param request クライアントが Servlet へ要求したリクエスト内容を含む HttpServletRequest オブジェクト。
	 * @param response Servlet がクライアントに返すレスポンス内容を含む HttpServletResponse オブジェクト。
	 * @throws ServletException Servlet が GET リクエストを処理している間に入出力エラーが発生した場合。
	 * @throws IOException Servlet が GET リクエストを処理している間に入出力エラーが発生した場合。
	 * Servlet に GET リクエストを処理可能にさせるため、(service メソッドを通じて) サーバによって呼び出される。<br>
	 * 直接アクセスに対して管理者ユーザーが既にログインしていたらメニュー画面にリダイレクトさせる。
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUserId") == null) {
			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("menu.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param request クライアントが Servlet へ要求したリクエスト内容を含む HttpServletRequest オブジェクト。
	 * @param response Servlet がクライアントに返すレスポンス内容を含む HttpServletResponse オブジェクト。
	 * @throws ServletException Servlet が POST リクエストを処理している間に入出力エラーが発生した場合。
	 * @throws IOException POST に相当するリクエストが処理できない場合。
	 * Servlet に POST リクエストを処理可能にさせるため、(service メソッド経由で) サーバによって呼び出される。<br>
	 * データベースに接続して従業員ユーザーを挿入する。<br>
	 * セッションに従業員コードをセットする。<br>
	 * 登録完了画面にリダイレクトさせる。
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");

		//セッションキーを用意
		HttpSession session = request.getSession();

		// リクエストパラメータの取得
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String lastKanaName = request.getParameter("lastKanaName");
		String firstKanaName = request.getParameter("firstKanaName");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String birthDay = request.getParameter("birthDay");
		String sectionCode = request.getParameter("sectionCode");
		String hireDate = request.getParameter("hireDate");
		String password = request.getParameter("password");

		// DAOの生成
		EmployeeDAO dao = EmployeeDAO.getInstance();

		boolean insertUserChkFlag = false;

		//DBにかかわる処理
		try {
			dao.dbConnect();
			dao.createSt();
			insertUserChkFlag = dao.insertEmployee(lastName, firstName, lastKanaName, firstKanaName, gender, birthDay, sectionCode,
					hireDate, password);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.dbDiscon();
		}
		if (!insertUserChkFlag) {
			lastName = null;

		}

		session.setAttribute("lastName", lastName);
		//sessionにおいて、JSPに渡す
		if (insertUserChkFlag) {
			response.sendRedirect("completion.jsp");

		} else {
			response.sendRedirect("regist_error_employee.jsp");

		}

	}

}
