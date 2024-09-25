import tkinter
from tkinter import messagebox
import mega
from mega import Mega

mega_instance = Mega()

m = mega_instance.login()

messagebox.showinfo("Download Started","You will receive a notification when the download has finished.")

m.download_url('https://mega.nz/file/8OFWkJwb#Scuoi905VKJeUQb0YhBTJAEUEvvv_SAIlbqlFlNV1uM')

root = tkinter.Tk()
root.withdraw()

messagebox.showinfo("Download Completed","Winery.zip app is availble at 'winery_mega_downloader/'")