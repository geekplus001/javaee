package orders.vo;

public class OrderItem {
	/*
	 * 订单明细主键
	 */
	private Integer itemId;
	/*
	 * 货物名称
	 */
	private String name;
	/*
	 * 折扣类型：0、无折扣1、折扣2、促销
	 */
	private Integer discountType;
	/*
	 * 货物数量
	 */
	private Integer unitNum;
	/*
	 * 单位商品价格
	 */
	private Double unitPrice;

	/*
	 * 总金额（只读字段，显示）
	 */
	private Double sum;
	/*
	 * 订单编号
	 */
	private Integer orderId;
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDiscountType() {
		return discountType;
	}
	public void setDiscountType(Integer discountType) {
		this.discountType = discountType;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getUnitNum() {
		return unitNum;
	}
	public void setUnitNum(Integer unitNum) {
		this.unitNum = unitNum;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
}
