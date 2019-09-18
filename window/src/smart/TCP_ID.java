package smart;

/**
 * tcp协议中各个ID值
 * 
 */
public interface TCP_ID {
	byte HEAD = 0x11;//֡帧头
	byte END = 0X16;//帧尾
	byte WINDOWS =0X21;//窗户ID֡
	byte CLIENT =0x20;//客户
	byte WINDOW_LENGTH = 0x34;//窗户发送数据的长度
	byte APP_LENGTH = 0X07;//手机发送控制的长度
	byte AIR_CONDITION = 0X30;//空调控制
	byte WORK_MODE = 0X32;//工作模式
	byte CONTROL_MODE = 0X61;//控制模式
	byte NUCLEAR_LINK = 0X62;//核心板连接状态״̬
	byte LINK_INNER = 0X33;//内部连接状态״̬
	byte LINK_OUT = 0X34;//外部连接状态״̬
	byte LINK_CONTROL = 0X35;//连接状态控制
	byte WINDOW_RANGE = 0X31;//窗户幅度
	byte INFRARED_RECEIVER = 0x40;//红外接收器
	byte PM25 = 0X41;//PM2.5
	byte PM10 = 0X42;//PM10
	byte WIND_POWER = 0X43;//风力
	byte TP_OUT = 0X44;//外部温度
	byte TP_INNER = 0X50;//内部温度
	byte HUM_OUT = 0X45;//外部湿度
	byte HUM_INNER = 0X51;//内部湿度
	byte SMOKE = 0X52;//烟雾
	byte VOICE = 0X53;//声音
	byte CONTROL_RANGE = 0X60;//幅度控制
}