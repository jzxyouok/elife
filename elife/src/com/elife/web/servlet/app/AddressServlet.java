package com.elife.web.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.elife.model.beans.Address;
import com.elife.model.daoimpl.AddressDao;
import com.google.gson.Gson;

/**
 * @author 任创权
 * 编写时间  2016-6-6 上午9:34:52
 * TODO ---
 *
 */
@WebServlet("/address")
public class AddressServlet extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//
		doPost(req, resp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		Gson gson = new Gson();
		AddressDao addressDao = new AddressDao();
		/**
		 * <!--开始收货地址相关管理--> <!--上传收货地址，参数：完善的地址信息Address;返回值：List<Address>-->
		 * <string name="address_add_url">/address?type=1</string>
		 * <!--更新收货地址，参数：完善的地址信息Address;返回值：List<Address>--> <string
		 * name="address_update_url">/address?type=2</string>
		 * <!--删除收货地址，参数：地址id;返回值：List<Address>--> <string
		 * name="address_del_url">/address?type=3</string>
		 * <!--获取收货地址列表，参数：用户id;返回值：List<Address>或者”0”--> <string
		 * name="address_list_url">/address?type=4</string>
		 * <!--获取默认收货地址，参数：用户id;返回值：Address。（客户端维护必须有一个默认收货地址）--> <string
		 * name="address_default_url">/address?type=5</string>
		 */
		String type = req.getParameter("type");

		if (type.equals("1")) {

			String userid = req.getParameter("userid");
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			String defaultAddresss = req.getParameter("DefaultAddresss");

			int userId = Integer.parseInt(userid);

			System.out.println("--------------" + defaultAddresss);

			/*
			 * List<Address> address1 = new ArrayList<Address>(); userAddress =
			 * gson.fromJson(address, new Address().getClass());
			 */
			/*
			 * List<Address> addressList = new ArrayList<Address>(); Address
			 * userAddress = new Address(name, phone, address, defaultAddresss,
			 * userId); if (addressDao.insertAddress(userAddress)) { addressList
			 * = addressDao.selectAllAddress(userId); } else {
			 * 
			 * } writer.println(addressList);
			 */
		} else if (type.equals("2")) {

		} else if (type.equals("3")) {

		} else if (type.equals("4")) {

			JSONArray arr = new JSONArray();

			String userid = req.getParameter("userid");
			int useridi = Integer.parseInt(userid);
			List<Address> addressList = new ArrayList<Address>();
			addressList = addressDao.selectAllAddress(useridi);
			for (Address address : addressList) {
				JSONObject json = new JSONObject();
				json.put("id", address.getId());
				json.put("name", address.getName());
				json.put("address", address.getAddressexact());
				json.put("phone", address.getPhone());
				json.put("defaltAddress", address.getRemark());
				arr.put(json);
			}
			writer.println(arr);
		} else if (type.equals("5")) {

		}

	}

}
