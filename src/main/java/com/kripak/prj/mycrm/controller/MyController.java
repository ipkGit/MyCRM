package com.kripak.prj.mycrm.controller;


import com.kripak.prj.mycrm.entity.CustomerOrder;
import com.kripak.prj.mycrm.entity.Manager;
import com.kripak.prj.mycrm.service.CustomerOrderService;
import com.kripak.prj.mycrm.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    CustomerOrderService customerOrderService;

    @Autowired
    ManagerService managerService;

    @RequestMapping("/")//main page with list of orders different status (status 1- new, 2 - on work, 3 - completed )
    public String homePage(Model model) {
        List<CustomerOrder> customerOrderListStage1 = customerOrderService.getCustomerOrderList(1);
        List<CustomerOrder> customerOrderListStage2 = customerOrderService.getCustomerOrderList(2);
        List<CustomerOrder> customerOrderListStage3 = customerOrderService.getCustomerOrderList(3);

        model.addAttribute("customerOrderList1" , customerOrderListStage1);
        model.addAttribute("customerOrderList2" , customerOrderListStage2);
        model.addAttribute("customerOrderList3" , customerOrderListStage3);

        return "index";
    }

    @RequestMapping("/new_order") // page for create new order
    public String newUpdateOrderPage (Model model) {

        CustomerOrder customerOrder = new CustomerOrder();

        model.addAttribute("customerOrder",customerOrder);

        return "order_detail";
    }

    @RequestMapping("/save_order")// save order details and redirect to main page
    public String saveCustomerOrder (@ModelAttribute("newCustomerOrder") CustomerOrder customerOrder) {

        customerOrderService.saveOrUpdateOrder(customerOrder);

        return "redirect:/";
    }

    @RequestMapping("/edit_order") // page for change order details
    public String editCustomerOrder (@RequestParam ("orderID") int id, Model model) {

        CustomerOrder customerOrder = customerOrderService.getCustomerOrder(id);

        model.addAttribute("customerOrder", customerOrder);

        return "order_detail";
    }

    @RequestMapping("/managers") // show list of managers
    public String allManagers (Model model) {
        List<Manager> managerList = managerService.getAllManagerList();
        model.addAttribute("managers", managerList);

        return "managers";
    }

    @RequestMapping("/managers/manager_detail") // page for create manager
    public String newUpdateManager (Model model) {

        Manager manager = new Manager();

        model.addAttribute("manager", manager);

        return "manager_detail";
    }

    @RequestMapping("/managers/save_manager") //save manager details and redirect to manager page
    public String saveManager (@ModelAttribute("newManager") Manager manager) {

        managerService.saveOrUpdateManager(manager);

        return "redirect:/managers";
    }

    @RequestMapping("/updateStage") // option update stage on main page
    public String updateStageOrder (@RequestParam ("orderID") int id, @RequestParam("stage") int stage, Model model) {

        System.out.println("id: "+ id + " : stage" + stage);
        CustomerOrder customerOrder = customerOrderService.getCustomerOrder(id);

        System.out.println(customerOrder.getAddress());
        customerOrderService.setStageOrder(customerOrder, stage);

        return "redirect:/";
    }


}
