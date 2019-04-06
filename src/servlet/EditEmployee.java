package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.EmployeeDAO;
import model.entity.Employee;

/**
 * Servlet implementation class EmployeeEdit
 * @author Hideaki Yabe
 * データベースに接続して編集した従業員情報を更新するクラス。
 */
@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param request クライアントが Servlet へ要求したリクエスト内容を含む HttpServletRequest オブジェクト。
	 * @param response Servlet がクライアントに返すレスポンス内容を含む HttpServletResponse オブジェクト。
	 * @throws ServletException Servlet が GET リクエストを処理している間に入出力エラーが発生した場合。
	 * @throws IOException Servlet が GET リクエストを処理している間に入出力エラーが発生した場合。
	 * Servlet に GET リクエストを処理可能にさせるため、(service メソッドを通じて) サーバによって呼び出される。<br>
	 * 直接アクセスに対して従業員が既にログインしていたらメニュー画面にリダイレクトさせる。
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	 * データベースに接続して編集した従業員情報を更新する。
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");

		request.setCharacterEncoding("utf-8");
		String employeeCode = request.getParameter("employeeCode");
		String lastName = request.getParameter("lastName");
		employee.setLastName(lastName);
		String lastKanaName = request.getParameter("lastKanaName");
		employee.setLastKanaName(lastKanaName);
		String firstName = request.getParameter("firstName");
		employee.setFirstName(firstName);
		String firstKanaName = request.getParameter("firstKanaName");
		employee.setFirstKanaName(firstKanaName);
		int gender = Integer.parseInt(request.getParameter("gender"));
		employee.setGender(gender);
		String birthDay = request.getParameter("birthDay");
		employee.setBirthDay(birthDay);
		String hireDate = request.getParameter("hireDate");
		employee.setHireDate(hireDate);
		String sectionCode = request.getParameter("section_code");
		employee.setSectionCode(sectionCode);

		EmployeeDAO empdao = EmployeeDAO.getInstance();
		try {
			empdao.dbConnect();
			empdao.createSt();
			employee = empdao.updateEmployee(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			empdao.dbDiscon();
		}

		session.removeAttribute("employeeCode");
		session.setAttribute("employee", employee);
		response.sendRedirect("edit_completion.jsp");
	}

}
