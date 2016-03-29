package orders.vo;

public class PromotionOrderItem extends OrderItem{
	/*
	 * 促销价格
	 */
	private Double promotionPrice;
	/*
	 * 促销开始数量
	 */
	private Integer promotionNum;
	public PromotionOrderItem() {
		// TODO Auto-generated constructor stub
	}
	public Double getPromotionPrice() {
		return promotionPrice;
	}
	public void setPromotionPrice(Double promotionPrice) {
		this.promotionPrice = promotionPrice;
	}
	public Integer getPromotionNum() {
		return promotionNum;
	}
	public void setPromotionNum(Integer promotionNum) {
		this.promotionNum = promotionNum;
	}
	
}
