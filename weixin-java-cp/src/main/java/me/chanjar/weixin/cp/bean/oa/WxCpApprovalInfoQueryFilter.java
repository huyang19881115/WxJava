package me.chanjar.weixin.cp.bean.oa;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import me.chanjar.weixin.common.util.json.WxGsonBuilder;

import java.io.Serializable;

/**
 * <pre>
 *  批量获取审批单号的筛选条件，可对批量拉取的审批申请设置约束条件，支持设置多个条件
 *  注意:
 *  仅“部门”支持同时配置多个筛选条件。
 *  不同类型的筛选条件之间为“与”的关系，同类型筛选条件之间为“或”的关系
 * </pre>
 *
 * @author element
 */
@Data
public class WxCpApprovalInfoQueryFilter implements Serializable {

  private static final long serialVersionUID = 3318064927980231802L;

  private KEY key;

  private Object value;

  /**
   * To json string.
   *
   * @return the string
   */
  public String toJson() {
    return WxGsonBuilder.create().toJson(this);
  }

  /**
   * The enum Key.
   */
  @Getter
  public enum KEY {

    /**
     * template_id - 模板类型/模板id；
     */
    @SerializedName("template_id")
    TEMPLATE_ID("template_id"),
    /**
     * creator - 申请人；
     */
    @SerializedName("creator")
    CREATOR("creator"),
    /**
     * department - 审批单提单者所在部门；
     */
    @SerializedName("department")
    DEPARTMENT("department"),
    /**
     * sp_status - 审批状态。
     */
    @SerializedName("sp_status")
    SP_STATUS("sp_status"),
    /**
     * record_type - 审批单类型属性，1-请假；2-打卡补卡；3-出差；4-外出；5-加班； 6- 调班；7-会议室预定；8-退款审批；9-红包报销审批。
     */
    @SerializedName("record_type")
    record_type("record_type");

    private final String value;

    KEY(String value) {
      this.value = value;
    }
  }
}
