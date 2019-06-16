package com.sincere.web.admin;

import com.sincere.model.Type;
import com.sincere.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC)
                                Pageable pageable, Model model) {
        model.addAttribute("page", typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/edit")
    public String showEditPage(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-edit";
    }

    @GetMapping("/types/{id}/edit")
    public String getEditType(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-edit";
    }

    @PostMapping("/types/edit")
    public String updateEditType(HttpServletRequest request, @PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC)
            Pageable pageable, Model model, RedirectAttributes redirectAttributes) {
        String typeName = request.getParameter("name");
        String typeId = request.getParameter("id");

        Type type = typeService.updateType(typeName, typeId);
        System.out.println("type in controller update is : " + type);
        if (type == null) {
            redirectAttributes.addFlashAttribute("message", "更新失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "更新成功");
        }
        model.addAttribute("page", typeService.listType(pageable));
        return "redirect:/admin/types";
    }

    @GetMapping("/types/add")
    public String showAddPage(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-add";
    }

    @PostMapping("/types/add")
    public String addNewType(Model model, @PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC)
            Pageable pageable, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String typeName = request.getParameter("name");
        Type type = typeService.addType(typeName);
        System.out.println("type in controller added is " + type);
        if (type == null) {
            redirectAttributes.addFlashAttribute("message", "增加失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "增加成功");
        }
        model.addAttribute("page", typeService.listType(pageable));
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String deleteType(Model model, @PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC)
            Pageable pageable, RedirectAttributes redirectAttributes, @PathVariable Long id) {
        typeService.deleteType(id);
        redirectAttributes.addFlashAttribute("message", "删除成功");
        model.addAttribute("page", typeService.listType(pageable));
        return "redirect:/admin/types";
    }
}
